//
//  JourneyRepository.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 11/19/23.
//

import Foundation

protocol JourneyRepository {
    @discardableResult
    func fetchJourneyList(
        query: JourneyQuery,
        cached: @escaping () -> Void,
        completion: @escaping (Result<Void, Error>) -> Void
    ) -> Cancellable?
}
